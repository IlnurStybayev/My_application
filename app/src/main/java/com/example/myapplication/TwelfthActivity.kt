package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_fourteenth.*
import kotlinx.android.synthetic.main.activity_twelfth.*

class TwelfthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twelfth)
        var todoList = mutableListOf(
            Todo("Learn Recycler View", isCheked = true),
            Todo("Learn Fragments", isCheked = false),
            Todo("Learn Spinner", isCheked = true),
            Todo("Learn Activity Lifecycles", isCheked = true),
            Todo("Take a morning shower", isCheked = true),
            Todo("Learn a breakfast", isCheked = true),
            Todo("Learn Recycler View", isCheked = true),
            Todo("Learn Bottom Navigation View", isCheked = false),
            Todo("Learn Drag and Drop", isCheked = false),
            Todo("Djon Uick", isCheked = false),
            Todo("Take a night shower", isCheked = false),
            Todo("Listen to music", isCheked = true)
        )
        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, isCheked = false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
        btnBack12.setOnClickListener {
            finish()
        }
    }

}


