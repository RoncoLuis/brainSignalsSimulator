package pruebas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PruebaVisualizadorReportes {

    private String filepath;

    public PruebaVisualizadorReportes() {

        this.filepath = "nuevo.pdf";
        SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentpanel = factory.buildViewerPanel();
        ComponentKeyBinding.install(controller, viewerComponentpanel);      
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController())
        );
        controller.openDocument(filepath);

        JFrame applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.add(viewerComponentpanel);

        
        applicationFrame.pack();
        applicationFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new PruebaVisualizadorReportes();
    }
}
