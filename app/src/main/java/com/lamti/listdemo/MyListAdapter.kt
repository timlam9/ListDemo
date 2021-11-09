package com.lamti.listdemo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

// Ο Αντάπτορας που θα παίρνει τα δεδομένα και θα τα ενώνει με το item_my (δλδ το layout της κάθε γραμμής)
// Κάνει extend το ListAdapter
// O ListAdapter παίρνει το αντικείμενο "MyItem" και τον ViewHolder του αντικειμένου "ItemViewHolder"
class MyListAdapter(
    private val context: Context,
    private val onClick: (MyItem) -> Unit) : ListAdapter<MyItem, ItemViewHolder>(ItemDiff())
{

    // Καλείται την πρώτη φορά μόνο για να φτιάξει τον viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_my, parent, false)
        val viewHolder = ItemViewHolder(context, view)

        viewHolder.itemView.setOnClickListener { onClick(getItem(viewHolder.adapterPosition)) }

        return viewHolder
    }

    // Συνδέει το αντικείμενο της λίστας με το view του
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
        Log.d("fsda","Position: $position")
    }

}

// Μία κλάση που βοηθάει τον αντάπτορα να ξεχωρίζει τα αντικείμενα μεταξύ τους.
// Λέει στον αντάπτορα αν τα αντικείμενα είναι ίδια ή όχι
class ItemDiff : DiffUtil.ItemCallback<MyItem>() {

    // Ελέγχει αν τα αντικείμενα είναι ίδια
    override fun areItemsTheSame(oldItem: MyItem, newItem: MyItem): Boolean {
        return oldItem == newItem
    }

    // Ελέγχει αν το περιεχόμενο των αντικειμένων είναι ίδιο
    override fun areContentsTheSame(oldItem: MyItem, newItem: MyItem): Boolean {
        return oldItem.title == newItem.title
    }

}

// Μία κλάση που κρατάει τα views του αντικειμένου (εξου και το όνομα ViewHolder)
class ItemViewHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view) {

    // Το view του τίτλου
    private val titleView: TextView = itemView.findViewById(R.id.itemTitle)
    private val imageView: ImageView = itemView.findViewById(R.id.itemImage)

    // Η μέθοδος που δίνει τιμή στο view
    // περνάει το αντικείμενο στο view (δίνει τιμή στο view)
    fun bind(item: MyItem) {
        titleView.text = item.title
        setImageFromFirebase(imagePath = item.imagePath, imageView = imageView)
    }

    private fun setImageFromFirebase(imagePath: String = EMPTY, imageView: ImageView) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)

        Glide.with(context).load(imagePath).apply(options).into(imageView)
    }

}
