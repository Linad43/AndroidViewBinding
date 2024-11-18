package com.example.androidviewbinding.service

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidviewbinding.modal.GridViewModel
import com.example.androidviewbinding.R

class GridViewAdapter(
    private val list: List<GridViewModel>,
    private val context: Context,
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (view == null) {
            view = layoutInflater!!.inflate((R.layout.grid_view_item), null)
        }
        imageView = view!!.findViewById(R.id.imageIV)
        textView = view.findViewById(R.id.textTV)
        imageView.setImageResource(list[position].image)
        textView.text = list[position].name
        return view
    }
}