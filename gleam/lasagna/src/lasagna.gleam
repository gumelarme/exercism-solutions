// Please define the expected_minutes_in_oven function
pub fn expected_minutes_in_oven(){
  40
}

// Please define the remaining_minutes_in_oven function
pub fn remaining_minutes_in_oven(val: Int){
  expected_minutes_in_oven() - val
}

// Please define the preparation_time_in_minutes function
pub fn preparation_time_in_minutes(layers: Int){
  layers * 2
}
// Please define the total_time_in_minutes function
pub fn total_time_in_minutes(layers: Int, time_passed: Int){
  time_passed + preparation_time_in_minutes(layers)
}

// Please define the alarm function

pub fn alarm(){
  "Ding!"
}
