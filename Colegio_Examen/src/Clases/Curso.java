package Clases;

	import java.util.ArrayList;
	import java.util.List;

	public class Curso implements ICurso {
	    private String nombreCurso;
	    private List<IGrupo> listaGrupos;
	    private float notaMedia;

	    public Curso(int curso, String nivelEducativo, List<IGrupo> listaGrupos) throws Exception {
	        this.listaGrupos = listaGrupos;
	        calcularNotaMedia();
	        this.nombreCurso = curso + "-" + nivelEducativo.toUpperCase();
	    }

	    private void calcularNotaMedia() throws Exception {
	        float sumaNotas = 0.0f;
	        int totalAlumnos = 0;

	        for (IGrupo grupo : listaGrupos) {
	            List<Alumnos> alumnos = grupo.getListaAlumnos();
	            for (IAlumnos alumno : alumnos) {
	                sumaNotas += alumno.getNotaMedia();
	                totalAlumnos++;
	            }
	        }

	        if (totalAlumnos > 0) {
	            notaMedia = sumaNotas / totalAlumnos;
	            if (notaMedia < 5.0f) {
	                throw new Exception("Curso no supera la nota media de 5.0");
	            }
	        }
	    }

	    @Override
	    public String getNombreCurso() {
	        return nombreCurso;
	    }

	    @Override
	    public List<IGrupo> getListaGrupos() {
	        return listaGrupos;
	    }

	    @Override
	    public float getNotaMedia() {
	        return notaMedia;
	    }

		@Override
		public void setNombreCurso(String nombreCurso) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setListaGrupos(IGrupo[] listaGrupos) {
			// TODO Auto-generated method stub
			
		}
	}

