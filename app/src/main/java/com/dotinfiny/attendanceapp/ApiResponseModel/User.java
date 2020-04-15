package com.dotinfiny.attendanceapp.ApiResponseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("id")
@Expose
private String id;
@SerializedName("email")
@Expose
private String email;
@SerializedName("uuid")
@Expose
private String uuid;
@SerializedName("name")
@Expose
private String name;
@SerializedName("islogin")
@Expose
private String islogin;
@SerializedName("status")
@Expose
private String status;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getUuid() {
return uuid;
}

public void setUuid(String uuid) {
this.uuid = uuid;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getIslogin() {
return islogin;
}

public void setIslogin(String islogin) {
this.islogin = islogin;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}