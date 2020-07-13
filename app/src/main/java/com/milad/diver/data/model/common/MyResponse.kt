package com.milad.diver.data.model.common

data class MyResponse<T>(
    var status: Status,
    var data: T? = null,
    var throwable: Throwable? = null
) {

    companion object {

        fun <T> loading(data: T?=null): MyResponse<T> {
            return MyResponse(
                status = Status.LOADING,
                data = data
            )
        }

        fun <T> success(data: T): MyResponse<T>? {
            return MyResponse(
                status = Status.SUCCESS,
                data = data
            )
        }

        fun <T> failed(throwable: Throwable): MyResponse<T> {
            return MyResponse(
                status = Status.FAILED,
                throwable = throwable
            )
        }
    }
}

enum class Status {
    LOADING,
    SUCCESS,
    FAILED,
}