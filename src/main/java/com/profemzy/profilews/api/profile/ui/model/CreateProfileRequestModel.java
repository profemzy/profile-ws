package com.profemzy.profilews.api.profile.ui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProfileRequestModel {

    @NotNull(message="Address Cannot be blank")
    @Size(min=2, message = "Address must not be less than 2 characters")
    private String address;

    @NotNull(message="Phone Cannot be blank")
    @Size(min=11, message = "Phone must not be less than 11 characters")
    private String phone;

    @NotNull(message="Next of Kin Name Cannot be blank")
    @Size(min=2, message = "Next of Kin Name must not be less than 2 characters")
    private String nok;

    @NotNull(message="Next of Kin Phone Cannot be blank")
    @Size(min=11, message = "Next of Kin Phone must not be less than 11 characters")
    private String nokPhone;

    @NotNull(message="Next of Kin Occupation Cannot be blank")
    @Size(min=2, message = "Next of Kin Occupation must not be less than 2 characters")
    private String nokOccupation;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNok() {
        return nok;
    }

    public void setNok(String nok) {
        this.nok = nok;
    }

    public String getNokPhone() {
        return nokPhone;
    }

    public void setNokPhone(String nokPhone) {
        this.nokPhone = nokPhone;
    }

    public String getNokOccupation() {
        return nokOccupation;
    }

    public void setNokOccupation(String nokOccupation) {
        this.nokOccupation = nokOccupation;
    }
}
