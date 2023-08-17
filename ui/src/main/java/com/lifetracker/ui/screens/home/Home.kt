@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.lifetracker.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.lifetracker.ui.common.util.date.formatToDay
import com.lifetracker.ui.components.task.BasicTask
import org.joda.time.LocalDateTime

@Composable
fun HomeScreen(
    title: String = LocalDateTime.now().formatToDay(),
    state: HomeUIState
) {
    val scrollBehaviour = pinnedScrollBehavior()

    Scaffold(
        topBar = { HomeTopBar(title, scrollBehaviour) },
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val tasks = state.tasks
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(tasks) { index, task ->
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        BasicTask(
                            task = task,
                            modifier = Modifier.fillParentMaxWidth()
                        )
                        if (index < tasks.size - 1) {
                            Divider(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp),
                onClick = { state.onAddTask() }
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        }
    }
}

@Composable
private fun HomeTopBar(title: String, scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = { Text(text = title) },
        scrollBehavior = scrollBehavior
    )
}