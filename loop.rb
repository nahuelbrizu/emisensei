num = 0
count = 0
print 'escriba un numero ='
sumador = gets.chomp.to_i
print 'iniciamos ='
puts  num
lista= []
while num < 100 - sumador
  num = num + sumador
  count = count + 1
  lista.push(num)
  print 'ahora num ='
  puts num
end
print 'lista'

p lista




