package com.loaizasoftware.core.usecase

abstract class UseCase<in A, out B> {
    abstract suspend operator fun invoke(params: A): B
}