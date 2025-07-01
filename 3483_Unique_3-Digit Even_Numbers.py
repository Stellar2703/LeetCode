class Solution:
  def totalNumbers(self, digits: list[int]) -> int:
    nums = set()

    for i in range(len(digits)):
      a = digits[i]
      if a == 0:
        continue  # Skip numbers starting with 0

      for j in range(len(digits)):
        if j == i:
          continue
        b = digits[j]

        for k in range(len(digits)):
          if k == i or k == j:
            continue
          c = digits[k]

          if c % 2 == 0:  # Last digit must be even
            number = a * 100 + b * 10 + c
            nums.add(number)

    return len(nums)
