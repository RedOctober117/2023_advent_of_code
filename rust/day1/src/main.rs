use std::fs;
use std::collections::BTreeMap;

fn main() {
    part_one();
}

fn part_one() {
    let path = "input.txt";
    let contents = fs::read_to_string(path).expect("Should have been able to read the file");
    let parsed_vec: Vec<&str> = contents.rsplit("\r\n").collect();
    
    let sum = sum_lines(strip_letters(parsed_vec));
    println!("{}", sum);
}

fn strip_letters(s: Vec<&str>) -> Vec<Vec<u32>> {
    let mut result = Vec::new();
    for string in s {
        let mut string_result = Vec::new();
        for c in string.chars() {
            if c.is_ascii_digit() {
                let c_num = c.to_digit(10).unwrap();
                match c_num {
                    0_u32..=u32::MAX => string_result.push(c_num),
                }
            }
        }
        println!("{:?}", string_result);
        result.push(string_result);
    }
    result
}

fn index_line_numbers(file_contents: Vec<&str>) -> Vec<BTreeMap<u32, u32>> {
    let numbers = vec!["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    let mut file: Vec<BTreeMap<u32, u32>> = Vec::new();
    let mut file_tree: BTreeMap<u32, u32> = BTreeMap::new();
    
    for line in file_contents {
        for i in 0..line.len() - 1{
            let temp_slice = line.get(i..).unwrap();
            let line_map = 
        }
    }

    file
}

fn sum_lines(s: Vec<Vec<u32>>) -> u32 {
    let mut sum = 0;
    for line in s {
        let num = line[0]*10 + line[line.len() - 1];
        sum += num;
    }
    return sum
}

