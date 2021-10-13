def anios_a_segundos(anios)
  dias_anio = 365
  horas_en_dia = 24
  horas = 60
  segundos = 60
  seg_un_anio = dias_anio * horas_en_dia * horas * segundos
  puts("#{seg_un_anio}segundos de un anio")
  return anios * seg_un_anio
end
res = anios_a_segundos(2)
puts("#{res} \n ")

def duplicar(num)

  return num * 2
end

doble = duplicar(5)
puts("#{doble} ")

