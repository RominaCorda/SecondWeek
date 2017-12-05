package com.virtualpairprogrammers.services;



import com.virtualpairprogrammers.dao.VehicleDAO;
import com.virtualpairprogrammers.domain.Vehicle;

import java.util.List;

public class VehicleService
{
    private VehicleDAO vehicleDAO;

    public VehicleService()
    {
        vehicleDAO=new VehicleDAO();
    }

    public List<Vehicle> getAllvehicle(){ return this.vehicleDAO.getAllvehicle();}
    public boolean insertVehicle(Vehicle vehicle){return this.vehicleDAO.insertVehicle(vehicle);}
    public Integer getIdVehicle(String brand,String model, String fuel, String version, String capacity)
    { return this.vehicleDAO.getIdVehicle(brand, model, fuel, version, capacity); }
}
