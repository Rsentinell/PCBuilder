package Components;

import Components.Part.GPU;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GPUs implements Component, Serializable {
    private List<GPU> GPUs;
    public GPUs() {
        this.GPUs = new ArrayList<>();
    }

    @Override
    public void add(Object c) {
        GPUs.add((GPU)c);
    }

    @Override
    public void remove(Object c) {
        GPUs.remove(c);
    }

    @Override
    public GPU extract(int x) {
        return GPUs.get(x);
    }

    @Override
    public String printDetails() {
        return "";
    }

    @Override
    public int size() {
        return GPUs.size();
    }

    public int getWattage()
    {

        int total=0;
        for (GPU x: GPUs)
        {
            total+= x.getWattage();
        }
        return  total;
    }
   
}