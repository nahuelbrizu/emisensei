def segundos_a_anios(cant_segundos)
  dias_x_anio = 365
  horas_diarias = 24
  segundos = 60
  minutos = 60
  if (cant_segundos.is_a? String)
    resultado = 'MANDASTE UN STRING PAPA'
  elsif ( cant_segundos.is_a?(Numeric) && cant_segundos > 0)
    resultado = cant_segundos / segundos / minutos / horas_diarias / dias_x_anio
  end
  if (cant_segundos == 0)
    resultado = 'VALOR INVALIDO'
  end

  return resultado
end

def anios_desde(momento)
  ahora = Time.now
  return segundos_a_anios(ahora - momento)
end
dias_x_anio = 365
horas_diarias = 24
segundos = 60
minutos = 60
hs_x_anio = dias_x_anio * horas_diarias
puts "un anio tiene tantas  #{hs_x_anio} horas"

dias_decada =  10 * dias_x_anio

hs_x_decada = dias_decada * horas_diarias

puts "una decada tiene #{hs_x_decada} horas "

fecha_nac = Time.new "1992-02-06"
anios = anios_desde(fecha_nac)

puts "tenes #{anios.to_i} anios"


pregunta= segundos_a_anios(63072000)


puts "tenes #{pregunta.to_i}"