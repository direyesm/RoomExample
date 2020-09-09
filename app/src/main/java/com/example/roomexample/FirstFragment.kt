package com.example.roomexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomexample.database.Task
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), TaskAdapter.PassTheData {

    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
////        //Insertando algo a la lista
//      val task = Task(1, "Algo de prueba", false)
//////        val task01 = Task(2, "Algo de prueba 1", false)
//////        val task02 = Task(3, "Algo de prueba 2", false)
//        viewModel.insertTask(task)
//////        viewModel.insertTask(task01)
//////        viewModel.insertTask(task02)
////
//        //Delete Table
//       viewModel.deleteAllTask()

        //Instanciar elemento visual RV
        val mRecyclerView = recyclerView
        //Instanciar objeto de la clase Adapter
        val mAdapter = TaskAdapter(this)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        //        //Escuchar liveData del ViewModel
        viewModel.allTask.observe(viewLifecycleOwner, Observer {
            Log.d("OBJETO", it.toString())
            //Este hace update al adapter
            mAdapter.updateDataList(it)
        })

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        deletebton.setOnClickListener {
            viewModel.deleteAllTask()
        }

    }

    override fun passTheData(mtask: Task) {
        Toast.makeText(context, mtask.task, Toast.LENGTH_LONG).show()
    }
}