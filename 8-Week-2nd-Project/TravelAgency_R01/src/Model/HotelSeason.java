package Model;

import Helper.DBConnect;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 10. değerlendirme sorusu
public class HotelSeason {

    private int seasonId;


    private String seasonName;

    private String seasonStart;
    private String seasonEnd;
    private int hotelId;

    public HotelSeason() {
    }

    public HotelSeason(int seasonId, String seasonName, String seasonStart, String seasonEnd, int hotelId) {
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.hotelId = hotelId;
    }


    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonStart() {
        return seasonStart;
    }

    public void setSeasonStart(String seasonStart) {
        this.seasonStart = seasonStart;
    }

    public String getSeasonEnd() {
        return seasonEnd;
    }

    public void setSeasonEnd(String seasonEnd) {
        this.seasonEnd = seasonEnd;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public static ArrayList<HotelSeason> getList() {
        ArrayList<HotelSeason> seasonArrayList = new ArrayList<>();
        String query = "SELECT * FROM season";
        HotelSeason obj;
        try {
            Statement st = DBConnect.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new HotelSeason();
                obj.setSeasonId(rs.getInt("id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setSeasonName(rs.getString("season_name"));
                obj.setSeasonStart(rs.getString("season_start"));
                obj.setSeasonEnd(rs.getString("season_end"));
                seasonArrayList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seasonArrayList;

    }

    public static ArrayList<HotelSeason> get_List (int id)
    {
        ArrayList<HotelSeason> seasonArrayList = new ArrayList<> ();
        String query = "SELECT * FROM season WHERE hotel_id = ?";
        HotelSeason obj;
        try
        {
            Statement st = DBConnect.getInstance ().createStatement ();
            ResultSet rs = st.executeQuery (query);
            while (rs.next ())
            {
                obj = new HotelSeason ();
                obj.setSeasonId (rs.getInt ("id"));
                obj.setSeasonName (rs.getString ("season_name"));
                obj.setSeasonStart (rs.getString ("season_start"));
                obj.setSeasonEnd (rs.getString ("season_end"));
                obj.setHotelId (rs.getInt ("hotel_id"));

            }

        } catch (SQLException e)
        {
            e.printStackTrace ();
        }
        return seasonArrayList;

    }

    public static HotelSeason getFetch(int id) {
        HotelSeason obj = null;
        String query = "SELECT * FROM season WHERE id = ?";
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new HotelSeason();
                obj.setHotelId(rs.getInt("id"));
                obj.setSeasonName(rs.getString("season_name"));
                obj.setSeasonStart(rs.getString("season_start"));
                obj.setSeasonEnd(rs.getString("season_end"));
                obj.setHotelId(rs.getInt("hotel_id"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public static boolean add(String season_name, String season_start, String season_end, int hotel_id) {
        String query = "INSERT INTO season (season_name,season_start,season_end,hotel_id) VALUES (?,?,?,?)";

        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(query);
            pr.setString(1, season_name);
            pr.setString(2, season_start);
            pr.setString(3, season_end);
            pr.setInt(4, hotel_id);

            int response = pr.executeUpdate();

            if (response == -1) {
                Helper.showMsg("error");
            }
            return response != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return true;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM season WHERE id = ?";

        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public static boolean deletebySeasonId(int id) {
        boolean result = false;
        String query = "DELETE FROM season WHERE id = ?";

        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        result = true;
        return result;

    }

    public static ArrayList<HotelSeason> getList(int id) {
        ArrayList<HotelSeason> hotelTypeArrayList = new ArrayList<>();
        String query = "SELECT * FROM season WHERE hotel_id = ?";
        HotelSeason obj;
        try {
            PreparedStatement st = DBConnect.getInstance().prepareStatement(query);
            st.setInt(1, id);  // Set the parameter
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                obj = new HotelSeason();
                obj.setSeasonId(rs.getInt("id"));
                obj.setSeasonName(rs.getString("season_name"));
                obj.setSeasonStart(rs.getString("season_start"));
                obj.setSeasonEnd(rs.getString("season_end"));
                obj.setHotelId(rs.getInt("hotel_id"));

                hotelTypeArrayList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelTypeArrayList;

    }

    public static boolean update(HotelSeason hotelSeason) {
        String query = "UPDATE season SET season_name = ?, season_start = ?, season_end = ?, " +
                "hotel_id = ? WHERE id = ?";

        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(query);

            pr.setString(1, hotelSeason.getSeasonName());
            pr.setString(2, hotelSeason.getSeasonStart());
            pr.setString(3, hotelSeason.getSeasonEnd());
            pr.setInt(4, hotelSeason.getHotelId());
            pr.setInt(5, hotelSeason.getSeasonId());

            return pr.executeUpdate() != -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static HotelSeason getFetch(String seasonName, int hotelId) {
        HotelSeason obj = null;
        String query = "SELECT * FROM season WHERE season_name=? AND hotel_id=?";

        PreparedStatement pr = null;
        try {
            pr = DBConnect.getInstance().prepareStatement(query);
            pr.setString(1, seasonName);
            pr.setInt(2, hotelId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new HotelSeason();
                obj.setSeasonId(rs.getInt("id"));
                obj.setSeasonName(rs.getString("season_name"));
                obj.setSeasonStart(rs.getString("season_start"));
                obj.setSeasonEnd(rs.getString("season_end"));
                obj.setHotelId(rs.getInt("hotel_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;

    }

    public static String searchQuery(String hotel_id) {
        String query = "SELECT * FROM season WHERE hotel_id = '{{hotel_id}}'";

        query = query.replace("{{hotel_id}}", hotel_id);

        return query;

    }

    public static ArrayList<HotelSeason> searchSeasonList(String query) {
        ArrayList<HotelSeason> seasonArrayList = new ArrayList<>();

        try {
            Statement statement = DBConnect.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                seasonArrayList.add(HotelSeason.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return seasonArrayList;
    }

    public static HotelSeason match(ResultSet resultSet) throws SQLException {
        HotelSeason object = new HotelSeason();

        object.setSeasonId(resultSet.getInt("id"));
        object.setSeasonName(resultSet.getString("season_name"));
        object.setSeasonStart(resultSet.getString("season_start"));
        object.setSeasonEnd(resultSet.getString("season_end"));
        object.setHotelId(resultSet.getInt("hotel_id"));

        return object;
    }


}
