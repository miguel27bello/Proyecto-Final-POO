package entity;

public enum Career {

    ADMINISTRACION("Administración de Empresas"),
    ANTROPOLOGIA("Antropología"),
    ARQUITECTURA("Arquitectura"),
    ARTES_PLS("Artes Plásticas"),
    BIOLOGIA("Biología"),
    CIENCIA_POLITICA("Ciencia Política"),
    CINE_TV("Cine y Televisión"),
    CONTADURIA("Contaduría Pública"),
    DERECHO("Derecho"),
    DIS_GRF("Diseño Gráfico"),
    DIS_IND("Diseño Industrial"),
    ECONOMIA("Economía"),
    ENFERMERIA("Enfermería"),
    ESP_Y_FILOLOGIA("Español y Filología Clásica"),
    ESTADISTICA("Estadística"),
    ESTUDIOS_LITERARIOS("Estudios Literarios"),
    FARMACIA("Farmacia"),
    FILOLOGIA_ALM("Filología e Idiomas (Alemán)"),
    FILOLOGIA_ENG("Filologéa e Idiomas (Inglés)"),
    FILOLOGIA_FRN("Filología e Idiomas (Francés)"),
    FILOSOFIA("Filosofía"),
    FISICA("Física"),
    FISIOTERAPIA("Fisioterapia"),
    FONOAUDIOLOGIA("Fonoaudiología"),
    GELOGIA("Geología"),
    GEOGRAFIA("Geografía"),
    HISTORIA("Historia"),
    ING_AGRICOLA("Ingeniería Agrícola"),
    ING_AGRONOMICA("Ingeniería Agronómica"),
    ING_CIVIL("Ingeniería Civil"),
    ING_ELECTRICA("Ingeniería Eléctrica"),
    ING_ELECTRONICA("Ingeniería Electrónica"),
    ING_INDUSTRIAL("Ingeniería Industrial"),
    ING_MECANICA("Ingeniería Mecánica"),
    ING_MECATRONICA("Ingeniería Mecatrónica"),
    ING_QUIMICA("Ingeniería Química"),
    ING_SISTEMAS_COMP("Ingeniería de Sistemas y Computación"),
    LINGUISTICA("Lingüística"),
    MATEMATICAS("Matemáticas"),
    MEDICINA("Medicina"),
    MEDICINA_VET("Medicina Veterinaria"),
    MUSICA("Música"),
    MUSICA_INSTR("Música Instrumental"),
    NUTRICION("Nutrición y Dietética"),
    ODONTOLOGIA("Odontología"),
    PSICOLOGIA("Psicología"),
    QUIMICA("Química"),
    SOCIOLOGIA("Sociología"),
    TERAPIA_OCUP("Terapia Ocupacional"),
    TRABAJO_SOCIAL("Trabajo Social"),
    ZOOTECNIA("Zootecnia");

	private String tipo;

	private Career(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
