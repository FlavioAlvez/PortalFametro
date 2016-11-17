package br.edu.fametro.portal.model;

import java.util.Calendar;
import java.util.Date;

public class DateUtility implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1126642857967380866L;

	public static Date getDataAtualDate() {
		Calendar dt = Calendar.getInstance();
		return dt.getTime();
	}

	public static String getDataAtualHtml() {
		Date dt = getDataAtualDate();
		return DateToHtml(dt);
	}

	public static String getDataAtualMask() {
		Date dt = getDataAtualDate();
		return DateToMask(dt);
	}

	public static String getHoraAtual() {
		Calendar dt = Calendar.getInstance();

		return getHoraCompleta(dt.getTime());
	}

	public static Date HtmlToDate(String htmlDateInput) {
		// yyyy-MM-dd
		int ano = Integer.parseInt(htmlDateInput.split("-")[0]);
		int mes = Integer.parseInt(htmlDateInput.split("-")[1]);
		int dia = Integer.parseInt(htmlDateInput.split("-")[2]);

		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, ano);
		dt.set(Calendar.MONTH, mes - 1);
		dt.set(Calendar.DAY_OF_MONTH, dia);

		return dt.getTime();
	}

	public static Date maskToDate(String dateMaskInput) {
		// dd/MM/yyyy
		int dia = Integer.parseInt(dateMaskInput.split("/")[0]);
		int mes = Integer.parseInt(dateMaskInput.split("/")[1]);
		int ano = Integer.parseInt(dateMaskInput.split("/")[2]);

		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, ano);
		dt.set(Calendar.MONTH, mes - 1);
		dt.set(Calendar.DAY_OF_MONTH, dia);

		return dt.getTime();
	}

	public static String DateToHtml(Date javaDateType) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(javaDateType);

		String dia = String.valueOf(dt.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(dt.get(Calendar.MONTH) + 1);
		String ano = String.valueOf(dt.get(Calendar.YEAR));

		while (dia.length() < 2) {
			dia = "0".concat(dia);
		}
		while (mes.length() < 2) {
			mes = "0".concat(mes);
		}
		while (ano.length() < 4) {
			ano = "0".concat(ano);
		}

		return ano.concat("-").concat(mes).concat("-").concat(dia);
	}

	public static String DateToMask(Date javaDateType) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(javaDateType);

		String dia = String.valueOf(dt.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(dt.get(Calendar.MONTH) + 1);
		String ano = String.valueOf(dt.get(Calendar.YEAR));

		while (dia.length() < 2) {
			dia = "0".concat(dia);
		}
		while (mes.length() < 2) {
			mes = "0".concat(mes);
		}
		while (ano.length() < 4) {
			ano = "0".concat(ano);
		}

		return dia.concat("/").concat(mes).concat("/").concat(ano);
	}

	public static String getHoraCompleta(Date data) {
		String horas = String.valueOf(getHoras(data));
		String minutos = String.valueOf(getMinutos(data));
		String segundos = String.valueOf(getSegundos(data));

		while (horas.length() < 2) {
			horas = "0".concat(horas);
		}
		while (minutos.length() < 2) {
			minutos = "0".concat(minutos);
		}
		while (segundos.length() < 2) {
			segundos = "0".concat(segundos);
		}

		return horas.concat(":").concat(minutos).concat(":").concat(segundos);
	}

	public static String getDataHoraCompleta(Date data) {
		return DateToMask(data) + " " + getHoraCompleta(data);
	}

	public static Date setDataHoraCompleta(String data, String hora) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(maskToDate(data));
		dt.set(Calendar.HOUR_OF_DAY, getHoras(hora));
		dt.set(Calendar.MINUTE, getMinutos(hora));
		dt.set(Calendar.SECOND, getSegundos(hora));

		return dt.getTime();
	}

	public static int getSegundos(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.SECOND);
	}

	public static int getMinutos(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.MINUTE);
	}

	public static int getHoras(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.HOUR_OF_DAY);
	}

	public static int getSegundos(String horaCompleta) {
		return Integer.parseInt(horaCompleta.split(":")[2]);
	}

	public static int getMinutos(String horaCompleta) {
		return Integer.parseInt(horaCompleta.split(":")[1]);
	}

	public static int getHoras(String horaCompleta) {
		return Integer.parseInt(horaCompleta.split(":")[0]);
	}

	public static int getDia(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.DAY_OF_MONTH);
	}

	public static int getMes(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.MONTH);
	}

	public static int getSemestre(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		int mes = dt.get(Calendar.MONTH) + 1;

		if (mes <= 6)
			return 1;
		else
			return 2;
	}

	public static int getAno(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.YEAR);
	}
}