package com.campus.vuelosglobales.city.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.city.domain.entities.City;
import com.campus.vuelosglobales.city.domain.repositories.CityRepository;

@Repository
public class CityRepositoryImpl implements CityRepository{

    private final CityPersistenceAdapter cityPersistenceAdapter;
    
    public CityRepositoryImpl(CityPersistenceAdapter cityPersistenceAdapter) {
        this.cityPersistenceAdapter = cityPersistenceAdapter;
    }

    @Override
    public List<City> findAll() {
        return cityPersistenceAdapter.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityPersistenceAdapter.findById(id);
    }

    @Override
    public City save(City city) {
        return cityPersistenceAdapter.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityPersistenceAdapter.deleteById(id);
    }

}
