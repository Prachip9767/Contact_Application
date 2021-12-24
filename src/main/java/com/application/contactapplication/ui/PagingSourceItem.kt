package com.application.contactapplication.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.application.contactapplication.database.ContactDTO

class PagingSourceItem(private val contactList: ArrayList<ContactDTO>) : PagingSource<Int, ContactDTO>() {

    override fun getRefreshKey(state: PagingState<Int, ContactDTO>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ContactDTO> {
        val pageNumber = params.key ?: 1
        return try {
            LoadResult.Page(
                data = contactList,
                prevKey = null,
                nextKey = if (contactList.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}