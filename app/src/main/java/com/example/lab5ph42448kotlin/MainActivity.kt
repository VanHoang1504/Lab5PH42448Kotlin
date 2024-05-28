package com.example.lab5ph42448kotlin

import android.os.Bundle
import android.provider.ContactsContract.Contacts.AggregationSuggestions
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // bai 1
//            LoginApp()
//             bai2
//            val images = listOf(
//                R.drawable.abc, R.drawable.anhcuoi,
//                R.drawable.anhcuoi2
//            )
//            Column {
//                Icon(
//                    painter = painterResource(id = R.drawable.logofpt),
//                    contentDescription = "Logo",
//                    modifier = Modifier.size(150.dp)
//                )
//                HorizontalImageList(imageList = images)
//                VerticalImageList(imageList = images)
//            }
            // bai 3
//            Scaffold(floatingActionButton = {
//                FloatingActionButton(onClick = { /*TODO*/ }) {
//                    Icon(Icons.Filled.Add, contentDescription = "Add")
//
//                }
//            }) { innerPadding ->
//                NoteApp(paddingValues = innerPadding)
//            }


            //LAbbbbbbbbbbbb 5
//            LoginApp()
//                     LightSwitch()
            CategoryApp()
        }
    }

    @Composable
    fun LoginScreen() {
        val context = LocalContext.current
        var userName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var showDialog by remember {
            mutableStateOf(false)
        }
        var dialogMessage by remember {
            mutableStateOf("")
        }
        if (showDialog) {
            DialogComponent(
                onConfirmation = { showDialog = false },
                dialogTitle = "Notification",
                dialogMessage = dialogMessage
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logofpt),
                contentDescription = "logo",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text(text = "UserName") })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "PassWord") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(15.dp))
            RememberMeSwitch()
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {
                    if (userName.isNotBlank() && password.isNotBlank()) {
                        dialogMessage = "Login successful"
//
                    } else {
                        dialogMessage = "Please enter username and password"
                    }
                    showDialog = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Login")
            }
        }
    }

    @Composable
    fun HorizontalImageList(imageList: List<Int>) {
        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(16.dp)
        ) {
            imageList.forEachIndexed { index, image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Image Description",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .padding(start = if (index == 0) 0.dp else 8.dp, end = 8.dp)

                )
            }
        }
    }


    @Composable
    fun VerticalImageList(imageList: List<Int>) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            imageList.forEachIndexed { index, image ->
                Image(
                    painter = painterResource(id = image), contentDescription = "Image Description",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .padding(top = if (index == 0) 0.dp else 8.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                )
            }
        }
    }

    @Composable
    fun NoteApp(paddingValues: PaddingValues) {
        val notes = listOf("note 1", "node 2", "note 3", "node 4", "note 5", "node 6")
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(8.dp)
        ) {
            notes.forEach { note ->
                NoteCard(noteText = note)
            }
        }
    }

    @Composable
    fun NoteCard(noteText: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    color = Color.LightGray,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = noteText,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand Note",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }

    @Composable
    fun LoginApp() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray), contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                LoginScreen()
            }
        }
    }

    @Composable
    fun DialogComponent(
        onConfirmation: () -> Unit,
        dialogTitle: String,
        dialogMessage: String
    ) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.padding(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(dialogTitle, style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = dialogMessage, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = onConfirmation,
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "OK")
                    }
                }
            }

        }
    }

    @Composable
    fun RememberMeSwitch() {
        var isChecker by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(checked = isChecker, onCheckedChange = { isChecker = it })
            Text(text = "Remember Me?", modifier = Modifier.padding(start = 12.dp))
        }
    }

    @Composable
    fun LightSwitch() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val isChecked = remember {
                mutableStateOf(false)
            }
            if (isChecked.value) {
                Image(
                    painter = painterResource(id = R.drawable.den_on),
                    contentDescription = "Light is on",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.den_off),
                    contentDescription = "Light is off",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Switch(
                checked = isChecked.value, onCheckedChange = {
                    isChecked.value = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Green,
                    uncheckedThumbColor = Color.Gray,
                    checkedTrackColor = Color.Green.copy(alpha = 0.5f),
                    uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f),
                    checkedBorderColor = Color.Green.copy(alpha = 0.75f)

                )
            )
        }
    }


    @Composable
    fun CategoryApp() {
        val categories = listOf(
            "Fiction", "Mystery", "Science Fiction",
            "Fantasy", "Adventure", "Historical", "Horror", "Romance"
        )
        val suggestions = listOf(
            "Biography", "Cookbook", "Poetry", "Self-help",
            "Thriller"
        )

        var selectedCategories by remember { mutableStateOf(setOf<String>()) }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Choose a category:", style =
                MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            AssistChip(
                onClick = { /* Do something */ },
                label = { Text("Need help?") }
            )

            Spacer(modifier = Modifier.height(16.dp))
            CategoryChips(categories, selectedCategories, onCategorySelected = { category ->
                selectedCategories = if (selectedCategories.contains(category))
                    selectedCategories - category
                else
                    selectedCategories + category
            })

            Spacer(modifier = Modifier.height(16.dp))
            SuggestionChips(suggestions = suggestions, selectedCategories = selectedCategories,
                onSuggestionSelected = { suggestion ->
                    selectedCategories = selectedCategories + suggestion
                })
            if (selectedCategories.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                SelectedCategoriesChips(
                    selectedCategories = selectedCategories,
                    onCategoryRemoved = { category ->
                        selectedCategories = selectedCategories - category
                    })
                Spacer(modifier = Modifier.height(16.dp))
                AssistChip(
                    onClick = { selectedCategories = setOf() },
                    label = {
                        Text(
                            text = "Clear selection",
                            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(containerColor = Color.DarkGray),
                    border = AssistChipDefaults.assistChipBorder(borderColor = Color.Black)
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CategoryChips(
        categorys: List<String>,
        selectedCategories: Set<String>,
        onCategorySelected: (String) -> Unit
    ) {
        Text(text = "Choose categories: ", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            categorys.forEach { category ->
                FilterChip(
                    selected = selectedCategories.contains(category),
                    onClick = { onCategorySelected(category) },
                    label = { Text(text = category) },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

        }
    }

    @Composable
    fun SuggestionChips(
        suggestions: List<String>,
        selectedCategories: Set<String>,
        onSuggestionSelected: (String) -> Unit
    ) {
        Text(text = "Suggestions: ", style = MaterialTheme.typography.titleMedium)
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            suggestions.forEach { suggestion ->
                val isSelected = selectedCategories.contains(suggestion)
                val chipColors = if (isSelected) {
                    SuggestionChipDefaults.suggestionChipColors(
                        containerColor = Color.LightGray
                    )
                } else {
                    SuggestionChipDefaults.suggestionChipColors()
                }
                SuggestionChip(
                    onClick = { onSuggestionSelected(suggestion) },
                    label = { Text(suggestion) },
                    colors = chipColors,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

//        Row (modifier = Modifier.horizontalScroll(rememberScrollState())){
//            suggestions.forEach { suggestion -> {
//                val isSelected = selectedCategories.contains(suggestion)
//                val chipColors = if(isSelected){
//                    SuggestionChipDefaults.suggestionChipColors(containerColor = Color.LightGray)
//                }
//                else{
//                    SuggestionChipDefaults.suggestionChipColors()
//                }
//                SuggestionChip(onClick = {onSuggestionSelected(suggestion)}, label = { Text(text = (suggestion)) ,
//                colors = chipColors}
//                    )
//            } }
//
//        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SelectedCategoriesChips(
        selectedCategories: Set<String>,
        onCategoryRemoved: (String) -> Unit
    ) {
        Text(
            "Selected categories:", style =
            MaterialTheme.typography.titleMedium
        )
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            selectedCategories.forEach { selectedCategory ->
                InputChip(
                    selected = true,
                    onClick = { },
                    label = { Text(selectedCategory) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Deselect",
                            modifier = Modifier
                                .clickable {
                                    onCategoryRemoved(selectedCategory)
                                }
                                .size(18.dp)
                        )
                    },
                    modifier = Modifier.padding(end = 8.dp),
                )
            }
        }
    }
}