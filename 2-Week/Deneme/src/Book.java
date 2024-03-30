public class Book {


    private String name;
    private int pageNumber;

    public int getPageNumber ()
        {
            return pageNumber;
        }


    public String getName ()
        {
            return name;
        }

    public void setName (String name)
        {
            this.name = name;
        }

    public Book (String name , int pageNumber)
        {
            this.name = name;
            if ( pageNumber < 100 )
                {
                    pageNumber = 0;
                }
            this.pageNumber = pageNumber;
        }

    public int showPageNumber ()
        {
            return this.pageNumber;
        }

    public void setPageNumber (int pageNumber)
        {
            if ( pageNumber < 0 )
                {
                    pageNumber = 0;
                }
            this.pageNumber = pageNumber;
        }

    public String showName ()
        {
            return this.name;
        }

    public String changeName (String name)
        {
            return name;        //eğer this. name e dönersek başta tanımlanan name ne ise o olur fakat burda change.name
            // dediğimiz için değiştirdiğimiz adı bastırmak için this eklemeden name diyip bu method
            //  içinde değiştirilen isim değerini yazdırırırz.
        }
}
