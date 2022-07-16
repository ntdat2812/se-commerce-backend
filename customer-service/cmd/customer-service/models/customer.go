package models

type Customer struct {
	Id   int64  `json:"id,omitempty"`
	Name string `json:"name,omitempty"`
}
