package com.thundercsun.lomonosovv.app.di.module;

import dagger.Module;

@Module(includes = {NetworkModule.class})
public class RepositoryModule {

    /*@Provides
    @Singleton
    FilmRepository provideFilmRepository(FilmService filmService) {
        return new FilmRepositoryImpl(filmService);
    }*/
}
