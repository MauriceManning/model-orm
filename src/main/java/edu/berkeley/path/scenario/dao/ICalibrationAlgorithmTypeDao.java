package edu.berkeley.path.scenario.dao;

import edu.berkeley.path.scenario.model.ICalibrationAlgorithmType;

import java.util.List;

/**
 *
 */
public interface ICalibrationAlgorithmTypeDao {

    ICalibrationAlgorithmType getCalibrationAlgorithmType(long calibrationAlgorithmTypeId);

    List<ICalibrationAlgorithmType> getCalibrationAlgorithmTypes();

    public long addCalibrationAlgorithmType( ICalibrationAlgorithmType cat );

    public void updateCalibrationAlgorithmType( ICalibrationAlgorithmType cat );

    public void deleteCalibrationAlgorithmType( ICalibrationAlgorithmType cat );

}
