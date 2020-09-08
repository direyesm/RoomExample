package com.example.roomexample

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexample.database.Task
import kotlinx.android.synthetic.main.task_item_list.view.*

class TaskAdapter(val list: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val taskText = itemView.taskTv
        val checkTask = itemView.checkBoxTask
        val idText = itemView.idTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}