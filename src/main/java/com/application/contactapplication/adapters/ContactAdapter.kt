package com.application.contactapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.contactapplication.R
import com.application.contactapplication.databinding.ItemLayoutBinding
import com.application.contactapplication.interfaces.OnCardClicked
import com.application.contactapplication.database.ContactDTO

class ContactAdapter(private val contactList: List<ContactDTO>, private val onCardClicked: OnCardClicked) : PagingDataAdapter<ContactDTO,ContactViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ContactDTO>() {
            override fun areItemsTheSame(oldItem: ContactDTO, newItem: ContactDTO): Boolean {
                return newItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: ContactDTO, newItem: ContactDTO): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemLayoutBinding: ItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout,
            parent,
            false
        )
        return ContactViewHolder(itemLayoutBinding,onCardClicked)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactDTO = contactList[position]
        holder.onBind(contactDTO)
    }

}

class ContactViewHolder(private val itemLayoutBinding: ItemLayoutBinding, private val onCardClicked: OnCardClicked) : RecyclerView.ViewHolder(itemLayoutBinding.root) {
    fun onBind(contactDTO: ContactDTO) {
        itemLayoutBinding.contact = contactDTO
        itemLayoutBinding.onCardClicked = onCardClicked
    }
}
