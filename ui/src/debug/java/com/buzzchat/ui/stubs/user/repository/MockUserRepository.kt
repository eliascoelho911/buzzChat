package com.buzzchat.ui.stubs.user.repository

import com.buzzchat.ui.features.user.model.User
import com.buzzchat.ui.features.user.repository.UserRepository
import com.buzzchat.ui.stubs.user.UserStub

class MockUserRepository : UserRepository {
    override fun getLoggedUser(): User = UserStub.getLoggedUser()
}