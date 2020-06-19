package com.thundercsun.lomonosovv.app.di.module;

import dagger.Module;

@Module(includes = {RepositoryModule.class})
public class UseCaseModule {

 /*   @Provides
    @Singleton
    FilmUseCase provideFilmUsercase(FilmRepository filmRepository, FilmMapper filmMapper) {
        return new FilmUseCaseImpl(filmRepository, filmMapper);
    }

    @Provides
    @Singleton
    FilmMapper provideFilmMapper() {
        return new FilmMapper();
    }*/
}
