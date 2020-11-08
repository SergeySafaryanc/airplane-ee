package ru.sfedu.airplane.repository.impl;

import ru.sfedu.airplane.model.Pilot;
import ru.sfedu.airplane.repository.PilotRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PilotRepositoryImpl extends CrudRepositoryImpl<Pilot, Long> implements PilotRepository {
}
