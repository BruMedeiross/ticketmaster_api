package com.brunadev.bookstore

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.brunadev.bookstore.data.GetAllBooks
import com.brunadev.bookstore.repository.BookstoreRepository
import com.brunadev.bookstore.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private val testScope = TestCoroutineScope(testDispatcher)

    @Mock
    private lateinit var mockRepository: BookstoreRepository

    @Mock
    private lateinit var mockListStateObserver: Observer<GetAllBooks?>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(mockRepository)
        viewModel.listState.observeForever(mockListStateObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `test init should fetch books and update emptylist state`() {
        testScope.runBlockingTest {
            // Given
            val mockApiResponse = GetAllBooks(1, "", "", emptyList())
            `when`(mockRepository.getBooksAPICoroutines()).thenReturn(mockApiResponse)

            // When
            viewModel.init()

            // Then
            assert(viewModel.listState.value == mockApiResponse)
        }
    }
}
