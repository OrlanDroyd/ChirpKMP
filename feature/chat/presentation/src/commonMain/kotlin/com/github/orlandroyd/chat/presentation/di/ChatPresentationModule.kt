package com.github.orlandroyd.chat.presentation.di

import com.github.orlandroyd.chat.presentation.chat_list.ChatListViewModel
import com.github.orlandroyd.chat.presentation.chat_list_detail.ChatListDetailViewModel
import com.github.orlandroyd.chat.presentation.create_chat.CreateChatViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val chatPresentationModule = module {
    viewModelOf(::ChatListViewModel)
    viewModelOf(::ChatListDetailViewModel)
    viewModelOf(::CreateChatViewModel)
}