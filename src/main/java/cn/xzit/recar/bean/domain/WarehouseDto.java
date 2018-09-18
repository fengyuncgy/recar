package cn.xzit.recar.bean.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDto {
    private int id;
    private Integer partid;
    private Integer inPrice;
    private Integer ourPrice;
    private Integer num;
    private String erorrMessage;
    private String place;
    private String partName;
    private String groupName;
}
