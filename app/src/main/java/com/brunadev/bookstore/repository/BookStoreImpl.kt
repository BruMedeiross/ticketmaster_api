package com.brunadev.bookstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brunadev.bookstore.data.GetAllBooks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class BookStoreImpl : BookstoreRepository {

    private val remoteDataSource = RemoteDataSource()
    private val compositeDisposable = CompositeDisposable()


    override suspend fun getBooksAPICoroutines(): GetAllBooks =
        remoteDataSource.bookListAPI()

    override suspend fun findBook(book: String): GetAllBooks =
        remoteDataSource.searchBook(book)


    override fun getBooksAPIRX(): LiveData<GetAllBooks?> {
        val data = MutableLiveData<GetAllBooks?>()

        val disposableObserver = remoteDataSource.bookList()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<GetAllBooks?>() {
                override fun onComplete() {
                }

                override fun onNext(response: GetAllBooks) {
                    if (response.resultsList != null) {
                        data.postValue(response)
                    } else {
                        data.postValue(null)
                    }
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    data.postValue(null)
                }
            })

        disposableObserver?.let { compositeDisposable.add(it) }
        return data

    }
}

