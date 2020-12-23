teta = [2,2,4,2,5,3,5,7,3,2]
p = 21
n = 50
c = 3
tau = 1

#   functions

def countTct(array):
    sum = 0
    for i in range(len(array)):
        sum += array[i]
    return sum

def create_arr_t_j_tau(array, time):
    result_arr = []
    for i in range(len(array)):
        result_arr.append(array[i] + time)
    return result_arr

def find_max(array):
    max = array[0]
    for i in range(1, len(array)):
        if array[i] > max:
            max = array[i]
    return max

def find_delta_teta_j(array):
    arr = []
    arr.append(array[0])
    j=2
    while(j<=len(array)):
        sum = 0
        for i in range(2, j):
            sum += max(array_t_j_tau[i] - array_t_j_tau[i -1], 0)
        arr.append(array[0] + sum)
        j+=1
    return arr

def func_max_in_sigma(x, y, array_t, array_teta):
    max_value = y * array_t[0] + array_teta[0] * (x-y)
    for i in range (1, len(array_t)):
        temp = y * array_t[i] + array_teta[i] + (x-y)
        if temp > max_value:
            max_value = temp
    return max_value

def find_sigma_x_y(x, y, array_t, array_teta, t):
    tmp = func_max_in_sigma(x, y, array_t, array_teta)
    res = min(((y-1) * min(array_t[0], array_t[len(array_t)-1])) + ((x-y) * array_t[len(array_t)-1]), t - tmp )
    return res

def comparison_time(time1, time2, time3):
    arr = []
    arr.append(time1)
    arr.append(time2)
    arr.append(time3)
    arr.sort()
    print("time =", arr)

#   code

if p%c == 0:
    print("True")

m = p // c
print("m =",m)
k = n // p
print("k =",k)
r = n - k*p
print("r =",r)

print("Counting T_c_tau ...")
T_c_tau = countTct(teta)
print("T_c_tau =", T_c_tau)


print("Array of t_j_tau:")
array_t_j_tau = []
array_t_j_tau = create_arr_t_j_tau(teta, tau)
print("array_t_j_tau =", array_t_j_tau)


print("Find the max element among elements of the array t_j_tau ...")
t_max_tau = find_max(array_t_j_tau)
print("t_max_tau = ", t_max_tau)


if (p == n or p < n) and T_c_tau <= m * t_max_tau:
    T_c_a = T_c_tau + ((n // c) - 1) * t_max_tau
elif p < n and T_c_tau > m * t_max_tau:
    T_c_a = (k + 1) * T_c_tau + ((r // c) - 1) * t_max_tau

print("T_c_a = ", T_c_a)
T_c_1 = T_c_a
print("T_c_1 =", T_c_1)

sum = 0
for j in range(2, len(array_t_j_tau)):
    sum += max(array_t_j_tau[j] - array_t_j_tau[j -1], 0)
delta_teta_s = array_t_j_tau[0] + sum
print("delta_teta_s =", delta_teta_s)

T_c_2_m_shtrih = T_c_tau + (m - 1) * delta_teta_s
print("T_c_2_shtrih =", T_c_2_m_shtrih)


T_c_2_rc_shtrih = T_c_tau + ((r//c) - 1) * delta_teta_s
print("T_c_2_rc_shtrih =", T_c_2_rc_shtrih)


delta_teta_j = []
delta_teta_j = find_delta_teta_j(array_t_j_tau)
print("delta_teta_j =", delta_teta_j)

sigma_m_m = find_sigma_x_y(m, m, array_t_j_tau, delta_teta_j, T_c_2_m_shtrih)
print("sigma_m_m =", sigma_m_m)

val_rc = r // c
print("val_rc =",val_rc)
sigma_m_rc = find_sigma_x_y(m, val_rc, array_t_j_tau, delta_teta_j, T_c_2_m_shtrih)
print("sigma_m_rc =", sigma_m_rc)

T_c_2 = k * T_c_2_m_shtrih - (k - 1) * sigma_m_m + T_c_2_rc_shtrih - sigma_m_rc
print("T_c_2 =", T_c_2)

comparison_time(T_c_a, T_c_1, T_c_2)