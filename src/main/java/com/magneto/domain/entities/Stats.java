package com.magneto.domain.entities;

public class Stats {
	long _countMutants;
	long _countHumans;
	double _ratio;
	
	public Stats(long countMutants, long countHumans) {
		_countMutants = countMutants;
		_countHumans = countHumans;
		double mutants = countMutants;
		double humans = countHumans;
		_ratio = mutants/humans;
	}
	
	public long get_countMutants() {
		return _countMutants;
	}
	
	public double get_ratio() {
		return _ratio;
	}

	public void set_ratio(double _ratio) {
		this._ratio = _ratio;
	}

	public long get_countHumans() {
		return _countHumans;
	}

	public void set_countMutants(long _countMutants) {
		this._countMutants = _countMutants;
	}
}
