package PCBuilder;

import Components.*;
import Components.Component.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Components components;
    static Cases cases;
    static CPUs cpus;
    static GPUs gpus;
    static MemoryModules memoryModules;
    static Motherboards motherboards;
    static PSUs psus;
    static StorageComponents storageComponents;
    //static List<Component> components = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        components = new Components();
        cases = new Cases();
        cpus = new CPUs();
        gpus = new GPUs();
        memoryModules = new MemoryModules();
        motherboards = new Motherboards();
        psus = new PSUs();
        storageComponents = new StorageComponents();

        components.addComponents(cases, cpus, gpus, memoryModules, motherboards, psus, storageComponents);

        Scanner sc = new Scanner(new File("PCParts/parts.csv"));

        //parse cpus
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] fields = line.split(",");

            String serialNumber = fields[1];
            String type = fields[2];
            double price = Double.parseDouble(fields[5]);
            double wattage = Double.parseDouble(fields[9]);
            String brand = fields[3];

            switch (fields[0]) {
                case "Case":
                    //components.add(new Case(serialNumber, type, brand, price, wattage));
                    break;
                case "Cpu":
                    cpus.addCPU(new CPU(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                 //   components.add(new CPU(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                case "Cooler":
                    //components.add(new Cooling(serialNumber, type,brand, "socket", price, wattage));//  Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                case "Gpu":
                    // components.add(new GPU(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                case "RAM":
                    // components.add(new Memory(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                case "MotherB":
                    // components.add(new Motherboard(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                case "PowerSupply":
                    // components.add(new PSU(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                case "Storage":
                    // components.add(new Storage(serialNumber, type, price, wattage, brand, Double.parseDouble(fields[6]), Integer.parseInt(fields[7]), fields[8]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + fields[0]);

            }
        }
        sc.close();
    }
}