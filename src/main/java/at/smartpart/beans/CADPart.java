package at.smartpart.beans;

public class CADPart {

    private int id;
    String prt_number;
    double bbx_max;
    double bbx_med;
    double bbx_min;
    double volume;
    double surface;
    double density;
    int total_surfaces;
    int plane_surfaces;
    
    private String firstName, lastName;

    public CADPart(int id, String prt_number, double bbx_max, double bbx_med, double bbx_min,
            double volume, double surface, double density, int total_surfaces, int plane_surfaces) {
        this.id = id;
        this.prt_number = prt_number;
        this.bbx_max = bbx_max;
        this.bbx_med = bbx_med;
        this.bbx_min = bbx_min;
        this.volume = volume;
        this.surface = surface;
        this.density = density;
        this.total_surfaces = total_surfaces;
        this.plane_surfaces = plane_surfaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrtNumber() {
        return prt_number;
    }

    public void setPrtNumber(String prt_number) {
        this.prt_number = prt_number;
    }

    public double getMaxDim() {
        return bbx_max;
    }

    public void setMaxDim(double bbx_max) {
        this.bbx_max = bbx_max;
    }
    
    public double getMedDim() {
        return bbx_med;
    }

    public void setMedDim(double bbx_med) {
        this.bbx_med = bbx_med;
    }
    
    public double getMinDim() {
        return bbx_min;
    }

    public void setMinDim(double bbx_min) {
        this.bbx_min=bbx_min;
    }
    
    
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume=volume;
    }
    
        public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface=surface;
    }
    
            public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density=density;
    }
    
    public int getTotalSurfaces() {
        return total_surfaces;
    }

    public void setTotalSurfaces(int total_surfaces) {
        this.total_surfaces=total_surfaces;
    }
        
    public int getPlaneSurfaces() {
        return plane_surfaces;
    }

    public void setPlaneSurfaces(int plane_surfaces) {
        this.plane_surfaces=plane_surfaces;
    }
}
