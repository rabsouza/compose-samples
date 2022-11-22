package com.example.sample.dojo.domain.useCases

interface BaseUseCase<P : UseCaseParams,T> {

    suspend fun run(params: P): Result<T>

}

interface UseCaseParams