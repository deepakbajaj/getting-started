package tech.donau.course;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.annotations.Pos;

import io.netty.util.internal.StringUtil;


@Path("/book")
public class BookResource {

  private static  List<String> allBooks = new ArrayList<>();
static
    {
allBooks.add("Deepak's quarkus Notes");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks(){

        return StringUtil.join(",", allBooks).toString();
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book){
        allBooks.add(book);
        return book;
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public String updateBook(@PathParam("id") Integer id, String book){
        allBooks.remove((int)id);
        return book;

    }


}
