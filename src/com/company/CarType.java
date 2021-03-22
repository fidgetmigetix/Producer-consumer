package com.company;

public interface CarType {
    enum Porsche implements CarType{
        Cayenne, Carrera, GranTurismo, Sport,
    }

    enum BMW implements CarType{
        x6, z4, e60, i3,
    }

    enum Tesla implements CarType{
        Roadster, ModelS, CyberTruck,
    }
}
