package com.picpay.desafio.android

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.feature.main.MainViewModel
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.persistense.repository.UserRepositoryContract
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response


@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class ExampleServiceTest {
    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var userRepository: UserRepositoryContract

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    internal fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        mainViewModel = MainViewModel(userRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getListUserTest() = dispatcher.runBlockingTest {
        whenever(userRepository.getListUser()).thenReturn(getListUserResponse())

        mainViewModel.getListUser()
        var result = mainViewModel.users
        assertTrue(result.value is List<User>)
    }

    @Test
    fun getListUserSizeTest() = dispatcher.runBlockingTest {
        whenever(userRepository.getListUser()).thenReturn(getListUserResponse())

        mainViewModel.getListUser()
        var result = mainViewModel.users
        assertTrue(result.value?.size == 1)
    }


    private fun mockedListUser(): List<User> = listOf(User(0,"img.png","Bruno","bruno_gallotti"))

    private fun getListUserResponse(): Response<List<User>> = Response.success(
        200,
        mockedListUser()
    )

}
