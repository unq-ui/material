package unq.edu.uis.tvSeries_xtrest.server;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Delete;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import unq.edu.uis.tvSeries.domain.Actor;
import unq.edu.uis.tvSeries.domain.Serie;
import unq.edu.uis.tvSeries.domain.TvSeriesSystem;

/**
 * Servidor RESTful implementado con XtRest.
 */
@Controller
@SuppressWarnings("all")
public class RestfulServer extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private TvSeriesSystem tvSeriesSystem;
  
  public RestfulServer(final TvSeriesSystem tvSeriesSystem) {
    this.tvSeriesSystem = tvSeriesSystem;
  }
  
  /**
   * Permite obtener el listado total de las series
   */
  @Get("/series")
  public Result getSeries(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    response.setContentType(ContentType.APPLICATION_JSON);
    return ResultFactory.ok(this._jSONUtils.toJson(this.tvSeriesSystem.getSeries()));
  }
  
  /**
   * Permite agregar un actor (con nombre y persona) a la serie informada por parámetro
   */
  @Post("/series/:nombreSerie/:nombreActor/:personaje")
  public Result agregarActor(final String nombreSerie, final String nombreActor, final String personaje, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    response.setContentType(ContentType.APPLICATION_JSON);
    try {
      final Actor actor = new Actor();
      actor.setNombre(nombreActor);
      actor.setPersonaje(personaje);
      final Serie serie = this.tvSeriesSystem.buscarSerie(nombreSerie);
      serie.agregarActor(actor);
      return ResultFactory.ok();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exception = (Exception)_t;
        String _message = exception.getMessage();
        String _plus = (_message + " No existe la serie con nombre: ");
        String _plus_1 = (_plus + nombreSerie);
        return ResultFactory.badRequest(this.getErrorJson(_plus_1));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Permite agregar un actor a la serie informada por parámetro. El actor debe ser enviado en el body del mensaje
   */
  @Post("/series/:nombreSerie")
  public Result agregarActor(@Body final String body, final String nombreSerie, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    response.setContentType(ContentType.APPLICATION_JSON);
    try {
      final Actor actor = this._jSONUtils.<Actor>fromJson(body, Actor.class);
      final Serie serie = this.tvSeriesSystem.buscarSerie(nombreSerie);
      serie.agregarActor(actor);
      return ResultFactory.ok();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exception = (Exception)_t;
        String _message = exception.getMessage();
        String _plus = (_message + " No existe la serie con nombre: ");
        String _plus_1 = (_plus + nombreSerie);
        return ResultFactory.badRequest(this.getErrorJson(_plus_1));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Permite eliminar un serie por su id.
   * 
   * Atiende requests de la forma DELETE /series/1.
   */
  @Delete("/series/:id")
  public Result deleteSerieById(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      final boolean eliminadoOk = this.tvSeriesSystem.eliminarSeriePorId(Integer.valueOf(id));
      Result _xifexpression = null;
      if (eliminadoOk) {
        _xifexpression = ResultFactory.ok();
      } else {
        _xifexpression = ResultFactory.badRequest(this.getErrorJson(("No existe la serie con identificador " + id)));
      }
      return _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        return ResultFactory.badRequest(this.getErrorJson("El id debe ser un número entero"));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private String getErrorJson(final String message) {
    return (("{ \"error\": \"" + message) + "\" }");
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/series").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = getSeries(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/series/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String nombreSerie = matcher.group(1);
    		
    		
    	    Result result = agregarActor(body, nombreSerie, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/series/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Delete") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = deleteSerieById(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/series/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String nombreSerie = matcher.group(1);
    		String nombreActor = matcher.group(2);
    		String personaje = matcher.group(3);
    		
    		
    	    Result result = agregarActor(nombreSerie, nombreActor, personaje, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
