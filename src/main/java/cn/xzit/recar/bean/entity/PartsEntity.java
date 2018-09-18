package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "parts", schema = "recar", catalog = "")
public class PartsEntity {
    private int partid;
    private String partName;
    private String specification;
    private Integer partGroupid;
    private Integer manufacturerid;
    private Collection<FlowPartEntity> flowPartsByPartid;
    private Collection<MaintenancePartEntity> maintenancePartsByPartid;
    private PartGroupsEntity partGroupsByPartGroupid;
    private ManufacturersEntity manufacturersByManufacturerid;
    private WarehouseEntity warehouseByPartid;

    @Id
    @Column(name = "partid", nullable = false)
    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }

    @Basic
    @Column(name = "part_name", nullable = true, length = 50)
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Basic
    @Column(name = "specification", nullable = true, length = 20)
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "part_groupid", nullable = true)
    public Integer getPartGroupid() {
        return partGroupid;
    }

    public void setPartGroupid(Integer partGroupid) {
        this.partGroupid = partGroupid;
    }

    @Basic
    @Column(name = "manufacturerid", nullable = true)
    public Integer getManufacturerid() {
        return manufacturerid;
    }

    public void setManufacturerid(Integer manufacturerid) {
        this.manufacturerid = manufacturerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsEntity that = (PartsEntity) o;
        return partid == that.partid &&
                Objects.equals(partName, that.partName) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(partGroupid, that.partGroupid) &&
                Objects.equals(manufacturerid, that.manufacturerid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(partid, partName, specification, partGroupid, manufacturerid);
    }

    @OneToMany(mappedBy = "partsByPartid",cascade = CascadeType.ALL)
    public Collection<FlowPartEntity> getFlowPartsByPartid() {
        return flowPartsByPartid;
    }

    public void setFlowPartsByPartid(Collection<FlowPartEntity> flowPartsByPartid) {
        this.flowPartsByPartid = flowPartsByPartid;
    }

    @OneToMany(mappedBy = "partsByPartid",cascade = CascadeType.ALL)
    public Collection<MaintenancePartEntity> getMaintenancePartsByPartid() {
        return maintenancePartsByPartid;
    }

    public void setMaintenancePartsByPartid(Collection<MaintenancePartEntity> maintenancePartsByPartid) {
        this.maintenancePartsByPartid = maintenancePartsByPartid;
    }

    @ManyToOne
    @JoinColumn(name = "part_groupid", referencedColumnName = "part_groupid",insertable=false,updatable=false)
    public PartGroupsEntity getPartGroupsByPartGroupid() {
        return partGroupsByPartGroupid;
    }

    public void setPartGroupsByPartGroupid(PartGroupsEntity partGroupsByPartGroupid) {
        this.partGroupsByPartGroupid = partGroupsByPartGroupid;
    }

    @ManyToOne
    @JoinColumn(name = "manufacturerid", referencedColumnName = "manufacturerid",insertable=false,updatable=false)
    public ManufacturersEntity getManufacturersByManufacturerid() {
        return manufacturersByManufacturerid;
    }

    public void setManufacturersByManufacturerid(ManufacturersEntity manufacturersByManufacturerid) {
        this.manufacturersByManufacturerid = manufacturersByManufacturerid;
    }

    @OneToOne(mappedBy = "partsByPartid",cascade = CascadeType.ALL)
    public WarehouseEntity getWarehouseByPartid() {
        return warehouseByPartid;
    }

    public void setWarehouseByPartid(WarehouseEntity warehouseByPartid) {
        this.warehouseByPartid = warehouseByPartid;
    }
}
