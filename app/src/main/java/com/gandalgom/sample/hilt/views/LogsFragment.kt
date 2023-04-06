package com.gandalgom.sample.hilt.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.gandalgom.sample.hilt.LogApplication
import com.gandalgom.sample.hilt.R
import com.gandalgom.sample.hilt.database.Log
import com.gandalgom.sample.hilt.database.LoggerLocalDataSource
import com.gandalgom.sample.hilt.util.DateFormatter

class LogsFragment : Fragment() {

    private lateinit var logger: LoggerLocalDataSource
    private lateinit var dateFormatter: DateFormatter

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById<RecyclerView?>(R.id.recycler_view).apply {
            setHasFixedSize(true)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        populateFields(context)
    }

    private fun populateFields(context: Context) {
        val serviceLocator = (context.applicationContext as LogApplication).serviceLocator
        logger = serviceLocator.loggerLocalDataSource
        dateFormatter = serviceLocator.provideDateFormatter()
    }

    override fun onResume() {
        super.onResume()

        logger.getAllLogs { logs ->
            recyclerView.adapter = LogsViewAdapter(logs, dateFormatter)
        }
    }
}

private class LogsViewAdapter(
    private val logsDataSet: List<Log>,
    private val daterFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewAdapter.LogsViewHolder>() {

    class LogsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logsText: TextView

        init {
            logsText = view.findViewById(R.id.log_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        return LogsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.log_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = logsDataSet[position]
        holder.logsText.text =
            String.format("%s\n\t%s", log.message, daterFormatter.formatDate(log.timeStamp))
    }

    override fun getItemCount(): Int = logsDataSet.size
}