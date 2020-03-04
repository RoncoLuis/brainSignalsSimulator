package app.utils;

import java.util.ArrayList;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CrearDataSet {
    
    public XYDataset crearDataSetXY(){
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        return dataset;
    }
    
    public XYSeries serieXY(String nombreSensor, ArrayList<Coordenadas> listaVoltaje){
    XYSeries series = new XYSeries(nombreSensor);
        for (int i = 0; i < listaVoltaje.size(); i++) {
            series.add(listaVoltaje.get(i).getX() , listaVoltaje.get(i).getY());
        }
    return series;
    }
}
