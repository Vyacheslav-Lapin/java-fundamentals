//usr/bin/env jshell --startup PRINTING "$0" "$@"; exit $?
import java.util.Random
new Random(); //$2
$2.nextInt(3) // $3
$2.nextInt(3) // $4
$2.nextInt(3) // $5

if ($3 == $4 && $3 == $5)
  printf("Выпало %d, %d, %d. Вы выиграли!\n", $3, $4, $5); else
  printf("Выпало %d, %d, %d. Вы проиграли!\n", $3, $4, $5)

/ex
