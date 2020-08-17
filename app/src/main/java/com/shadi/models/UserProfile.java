package com.shadi.models;

import java.io.Serializable;

import io.realm.RealmObject;

public class UserProfile extends RealmObject implements Serializable {

    String userStatus="NA";

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    name name;

    public class name  extends RealmObject{
        String title;
        String first;
        String last;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }

    location location;

    public class street  extends RealmObject{
        int number;
        String name;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public class location  extends RealmObject{
        street street;
        String city;
        String state;
        String postcode;

        public UserProfile.street getStreet() {
            return street;
        }

        public void setStreet(UserProfile.street street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        coordinates coordinates;

        public class coordinates  extends RealmObject{
            String latitude;
            String longitude;

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }
        }

        timezone timezone;

        public UserProfile.location.coordinates getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(UserProfile.location.coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public UserProfile.location.timezone getTimezone() {
            return timezone;
        }

        public void setTimezone(UserProfile.location.timezone timezone) {
            this.timezone = timezone;
        }

        public class timezone  extends RealmObject{
            String offset;
            String description;

            public String getOffset() {
                return offset;
            }

            public void setOffset(String offset) {
                this.offset = offset;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        @Override
        public String toString() {
            return street + " " + postcode + " " + city + " " + state;
        }
    }

    String email;
    login login;

    public class login  extends RealmObject{
        String uuid;
        String username;
        String password;
        String salt;
        String md5;
        String sha1;
        String sha256;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getSha1() {
            return sha1;
        }

        public void setSha1(String sha1) {
            this.sha1 = sha1;
        }

        public String getSha256() {
            return sha256;
        }

        public void setSha256(String sha256) {
            this.sha256 = sha256;
        }
    }

    dob dob;

    public class dob  extends RealmObject{
        String date;
        String age;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    registered registered;

    public class registered  extends RealmObject{
        String date;
        String age;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    String phone;
    String cell;
    id id;

    public class id  extends RealmObject{
        String name;
        String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    picture picture;

    public UserProfile.name getName() {
        return name;
    }

    public void setName(UserProfile.name name) {
        this.name = name;
    }

    public UserProfile.location getLocation() {
        return location;
    }

    public void setLocation(UserProfile.location location) {
        this.location = location;
    }

    public UserProfile.login getLogin() {
        return login;
    }

    public void setLogin(UserProfile.login login) {
        this.login = login;
    }

    public UserProfile.dob getDob() {
        return dob;
    }

    public void setDob(UserProfile.dob dob) {
        this.dob = dob;
    }

    public UserProfile.registered getRegistered() {
        return registered;
    }

    public void setRegistered(UserProfile.registered registered) {
        this.registered = registered;
    }

    public UserProfile.id getId() {
        return id;
    }

    public void setId(UserProfile.id id) {
        this.id = id;
    }

    public UserProfile.picture getPicture() {
        return picture;
    }

    public void setPicture(UserProfile.picture picture) {
        this.picture = picture;
    }

    public class picture  extends RealmObject{
        String large;
        String medium;
        String thumbnail;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    String nat;
}
